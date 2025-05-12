import "reflect-metadata";
import express from 'express';
import sequelize from './config/database';
import dotenv from 'dotenv';

dotenv.config()

const app = express();

const port = process.env.PORT || 3000;
const host = process.env.HOST || 'localhost';

sequelize.authenticate()
    .then(() => sequelize.sync({ force: true }))
    .then(() => {
        app.listen(process.env.PORT, () => {
            console.log('✅ Servidor listo en http://' + host + ':' + port);
        });
    })
    .catch(error => {
        console.error('🔥 Error crítico:', error);
    });