// otpService.js
import nodemailer from 'nodemailer';

async function sendOTP(name, email, genOTP) {
  const htmlContent = `
    <html>
      <body>
        <div style="text-align: center; font-family: Arial, sans-serif;">
          <h2>Verify your OTP</h2>
          <p>Dear <h4>${name}</h4>, enter the below OTP for email validation</p>
          <p>Your OTP is:</p>
          <div style="display: inline-block; padding: 10px 20px; background-color: #007bff; color: #ffffff; font-size: 24px; font-weight: bold; border-radius: 5px;">
            ${genOTP}
          </div>
        </div>
      </body>
    </html>
  `;

  // Configure the transporter
  const transporter = nodemailer.createTransport({
    service: 'gmail',
    auth: {
      user: 'filehub777@gmail.com',
      pass: 'vhbi ueno rhhe enwa'  // Replace with your app-specific password
    }
  });

  // Mail options
  const mailOptions = {
    from: 'filehub777@gmail.com',
    to: email,
    subject: 'Welcome to FileHub',
    html: htmlContent
  };

  try {
    // Send the email
    await transporter.sendMail(mailOptions);
    console.log('Email sent successfully');
    return true;
  } catch (error) {
    console.error('Error sending email:', error);
    return false;
  }
}

export {sendOTP};
