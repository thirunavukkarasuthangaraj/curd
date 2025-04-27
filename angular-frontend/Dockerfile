# Use Node.js image
FROM node:18 AS build

WORKDIR /app

COPY angular-frontend/package.json angular-frontend/package-lock.json ./
RUN npm install --legacy-peer-deps

COPY angular-frontend/ .

RUN npm run build -- --configuration=production --no-progress --build-optimizer

# Use Nginx to serve
FROM nginx:alpine
COPY --from=build /app/dist/your-app-name /usr/share/nginx/html
COPY angular-frontend/nginx.conf /etc/nginx/conf.d/default.conf
