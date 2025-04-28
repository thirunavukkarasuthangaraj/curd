# Stage 1: Build Angular app
FROM node:18 AS build

WORKDIR /app

COPY angular-frontend/package.json angular-frontend/package-lock.json ./
RUN npm install --legacy-peer-deps

COPY angular-frontend/ .

RUN npm run build -- --configuration=production --no-progress --build-optimizer

# Stage 2: Serve with Nginx
FROM nginx:alpine

# ✅ Change 'your-app-name' to your actual Angular project name
COPY --from=build /app/dist/angular-frontend /usr/share/nginx/html

# 🔥 Option 1: If you have nginx.conf file
# COPY angular-frontend/nginx.conf /etc/nginx/conf.d/default.conf

# 🔥 Option 2: If no nginx.conf, then comment or delete the above COPY

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
