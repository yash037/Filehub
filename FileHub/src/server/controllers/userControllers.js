import bcrypt from 'bcrypt';
import { Op } from 'sequelize'; // Import Op for 'or' condition
import User from "../models/userModels.js";
import { sendOTP } from "../utils/otpService.js";  // Assume a service to send OTP
import { generateOTP } from "../utils/otpGenerator.js";  // Assume a utility to generate OTP

const loginUser = async (req, res) => {
  const { identifier, password } = req.body; // Identifier can be either email or username
  try {
    // Find user by email or username
    const user = await User.findOne({
      where: { [Op.or]: [{ email: identifier }, { username: identifier }] }
    });

    if (!user) {
      return res.status(404).json({ message: "User not found. Please sign up." });
    }

    // Check password
    const isPasswordValid = await bcrypt.compare(password, user.password);
    if (!isPasswordValid) {
      return res.status(401).json({ message: "Invalid password." });
    }

    return res.status(200).json({ message: "Login successful!" });
  } catch (error) {
    console.error("Error logging in:", error);
    return res.status(500).json({ message: "An error occurred during login." });
  }
};

const signupUser = async (req, res) => {
  const { name, email, password } = req.body;

  try {
    // Check if email already exists
    const existingUser = await User.findOne({ where: { email } });
    if (existingUser) {
      return res.status(400).json({ message: "Email already exists." });
    }

    // Validate password strength
    if (!isPasswordStrong(password)) {
      return res.status(400).json({ message: "Password must be strong." });
    }

    // Hash password
    const hashedPassword = await bcrypt.hash(password, 10);

    // Generate OTP and send it via email
    const otp = generateOTP();
    const otpSent = await sendOTP(email, otp);
    if (!otpSent) {
      return res.status(500).json({ message: "Error sending OTP. Please try again." });
    }

    // Save user with OTP
    const newUser = await User.create({ name, email, password: hashedPassword, otp });
    return res.status(201).json({ message: "OTP sent. Please verify your account." });
  } catch (error) {
    console.error("Error during signup:", error);
    return res.status(500).json({ message: "An error occurred during signup." });
  }
};

const verifyOtp = async (req, res) => {
  const { email, otp } = req.body;

  try {
    const user = await User.findOne({ where: { email } });
    if (!user || user.otp !== otp) {
      return res.status(400).json({ message: "Invalid OTP." });
    }

    // Clear OTP after successful verification
    user.otp = null;
    await user.save();

    return res.status(200).json({ message: "Signup successful!" });
  } catch (error) {
    console.error("Error verifying OTP:", error);
    return res.status(500).json({ message: "An error occurred during OTP verification." });
  }
};

// Helper function for password validation
function isPasswordStrong(password) {
  return /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/.test(password);
}

export {
  loginUser,
  signupUser,
  verifyOtp
};
