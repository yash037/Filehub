import express from "express";
import {
    loginUser,
    signupUser,
    verifyOtp
} from "../controllers/userControllers.js"

const router = express.Router();

router.post("/login", loginUser);
router.post("/signup", signupUser);
router.post("/verifyOtp", verifyOtp);

export default router;
