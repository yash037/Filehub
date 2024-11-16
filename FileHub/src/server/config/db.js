import mysql from 'mysql2/promise';

const db = mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: 'userroot',
    database: 'UserDB'
});

export default db;
