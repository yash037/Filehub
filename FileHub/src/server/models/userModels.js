import { Sequelize, DataTypes } from 'sequelize';

// Initialize Sequelize connection (adjust to use environment variables for security)
const sequelize = new Sequelize('mysql://root:userroot@localhost:3306/UserDB');

// Define the User model with name, email, and password fields
const User = sequelize.define('User', {
    name: {
        type: DataTypes.STRING,
        allowNull: false,
    },
    email: {
        type: DataTypes.STRING,
        allowNull: false,
        unique: true,
    },
    password: {
        type: DataTypes.STRING,
        allowNull: false,
    },
}, {
    timestamps: true, // Adds `createdAt` and `updatedAt` fields automatically
});

// Sync the model with the database
sequelize.sync()
    .then(() => console.log('User table has been created successfully.'))
    .catch((error) => console.error('Error syncing the database:', error));

export default User;
