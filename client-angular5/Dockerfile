# adapted from https://mherman.org/blog/dockerizing-an-angular-app/
# base image
FROM node:12.2.0
MAINTAINER MatthewD mbd06b@gmail.com
ENV APP_HOME /app
EXPOSE 4200

# add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# install and cache app dependencies
COPY package.json /app/package.json
RUN npm install
RUN npm install -g @angular/cli@7.3.9

# add app
COPY . $APP_HOME/
WORKDIR $APP_HOME

# start app
CMD ng serve --host 0.0.0.0
