import express from 'express';
import dotenv from 'dotenv';
import db from './config/db.js';
import userRoutes from './routes/userRoutes.js';

dotenv.config(); // Load environment variables

// Initialize express app
const app = express();

// Middleware to parse JSON
app.use(express.json());

// Routes
app.use("/api/auth", userRoutes);

// Port configuration
const PORT = process.env.PORT || 8080;

// Check database connection before starting the server
db.query('SELECT 1')
    .then(() => {
        app.listen(PORT, () => {
            console.log(`Server is listening on port ${PORT}`);
        });
    })
    .catch((error) => {
        console.error("MySQL Connection Error:", error);
    });
