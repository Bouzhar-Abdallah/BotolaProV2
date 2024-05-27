FROM node:18-alpine

RUN npm install -g @angular/cli

WORKDIR /angular-app

COPY . .
RUN npm install -g npm@10.5.1

RUN npm install

CMD ng serve --host 0.0.0.0 --port 4200

EXPOSE 4200
