import { Sequelize } from 'sequelize-typescript';
import 'reflect-metadata';
import path from 'path';
import dotenv from 'dotenv';

dotenv.config();

const dialect = 'postgres';

const sequelize = new Sequelize({
    database: process.env.DB_NAME as string,
    dialect: dialect,
    username: process.env.DB_USER as string,
    password: process.env.DB_PASSWORD as string,
    host: process.env.DB_HOST as string,
    port: parseInt(process.env.DB_PORT || '5432', 10),
    models: [path.join(__dirname, '../models/*.model.ts')],
    dialectOptions: {
        useUTC: false
    },
    logging: false
});

export default sequelize;