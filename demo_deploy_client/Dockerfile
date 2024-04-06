FROM node:21-alpine

WORKDIR /app
COPY package.json .

COPY package-lock.json .

RUN npm install
RUN npm install vite
COPY . .