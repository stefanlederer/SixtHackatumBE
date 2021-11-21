# Sixt Hackatum Challenge 2021

## Inspiration
SixT Innovation of Robotaxi has brought our attention, because of our interest in self-driving cars. Some of us want to pursue the AI in their masters with focus on self-driving technology. Unfortunately, since we are all Bachelors, we couldn't really get into that specific Topic. That is why we decided it would be the best to add our ideas of what could be a part of a robotaxi. First thoughts that we wanted to address were substitute of driver as a person that could be talked to. We wanted to add the possibility of entertainment while driving or to be more specific while being driven.

## What it does
Our app allows the customer to enjoy the ride beyond the self-driving car experience. It allows the user to communicate with other people that are travelling with the Robotaxi or discover the city they are travelling through. We can imagine that business representatives that are in town only for few hours, could use this possibility to get at least some facts about the city.

## How we built it
Since we all learned Java at TUM we used it in addition of Spring Framework and MySQL database in order to create the Outline of what could be implemented in the Robotaxi.

## Challenges we ran into
Unfortunately, although we wanted, we couldn't implement a Video chat in time and had to switch a simple chat. Afterall for some of us it was first big project beyond the University.

## Accomplishments that we're proud of
We are proud that with not big experience we managed to implement most of the features we wanted.

## What we learned
We've learned how to work in Team and under time stress. From the technical point of view every one of us learned something new. For Nensi Frontend was a new adventure Css and Html were new elements that she has never used before. For Stephan and Tadeusz BE and its sync with FE in Spring were something new since they didn't really used it before.

## What's next for SixtChallenge
There are many Ideas that we didn't have time to implement. For Example, Video Chat or the possibility to play its own music from the phone.


## SQL - Statements to add data to the database

Create chatrooms:
```
INSERT INTO chatroom_entity(id, name) VALUE (1, 'MunichForVisitors');
INSERT INTO chatroom_entity(id, name) VALUE (2, 'Sixt');
INSERT INTO chatroom_entity(id, name) VALUE (3, 'RobotCars');
```

Create a seightseeing:
```
INSERT INTO poi_entity (id, description, lat, lon, name, url_image) VALUE (123,'This is the description', '48.1673464', '11.5907059', 'Odeonsplatz', 'Odeonsplatz.png');
```

