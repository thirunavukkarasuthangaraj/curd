# Stage 1: Build Angular app
FROM node:18 AS build

WORKDIR /app

COPY package.json package-lock.json ./
RUN npm install --legacy-peer-deps

COPY . .

RUN npm run build -- --configuration=production --no-progress --build-optimizer

# Stage 2: Serve with Nginx
FROM nginx:alpine

# Replace 'employee-management-app' with your actual built folder name inside dist/
COPY --from=build /app/dist/angular-frontend /usr/share/nginx/html

# If you have nginx.conf, then uncomment
# COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]