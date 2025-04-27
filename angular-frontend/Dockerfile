# Step 1: Build Angular app
FROM node:16 as build-stage

WORKDIR /app

COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build --prod

# Step 2: Serve Angular app with Nginx
FROM nginx:latest

# ✅ Use custom nginx config
COPY nginx.conf /etc/nginx/conf.d/default.conf

# ✅ Copy Angular build output
COPY --from=build-stage /app/dist/angular-frontend /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
