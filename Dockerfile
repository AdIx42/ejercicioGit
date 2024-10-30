FROM node:10-alpine

WORKDIR /home
RUN npm config set strict-ssl false
RUN npm install
RUN npm install express --save


COPY app.js .
CMD [ "node", "app.js" ]