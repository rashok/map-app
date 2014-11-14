# SF Food Truck Finder

Food truck finder is a simple app to search for your favorite food trucks in San Francisco. This app is powered by Twitter Bootstrap + Leaflet JS Maps.

The user can search the map for specific foodie items like - sandwiches, pizza, coffee etc. The map then displays the locations of the matched food trucks.

If 2 or more locations are around concenterated in a small neighborhood, then the map clusters them together and shows a count. This cluster can be expanded by clicking on it.

This app has been deployed on Heroku. You can test it [here](https://evening-escarpment-9129.herokuapp.com/).

----------
**Data Set**

The data set for the food truck locations is available on [DataSF](https://data.sfgov.org/Economy-and-Community/Mobile-Food-Facility-Permit/rqzj-sfat?)

**Frameworks**

The app was build by using the below frameworks

 1. [Twitter Bootstrap v3.3](https://github.com/twbs/bootstrap.git)
 2. [Play Framework - Java v1.2.6](https://www.playframework.com/)
 3. [MapBoxJS](https://www.mapbox.com/mapbox.js/api/v2.1.4/) (Library for Fast & Interactive Maps Built on top of [Leaflet](http://leafletjs.com/))
 4. [Socrata API](https://github.com/socrata) - Open Data Platform the above data set.
 5. Leaflet Plugins for Map Markers - [Leaflet.markerCluster](https://github.com/Leaflet/Leaflet.markercluster) by [Dave Leaver](https://github.com/danzel)
 6. Java 1.7

**Project Structure**

Within the repo you'll find the following directories and files. This is a typical structure of a play app. You'll see something like this:

```
map-app/
├── app/  [All Application Sources are in this folder]
│   ├── controllers [Controller logic for the app]
│   ├── models [Model classes for Truck. Business Layer]
│   ├── utils [Connection Utils]
│   └── views [index.html]
├── conf/ [Application Configuration Files, Dependencies, Routes Definition]
├── lib/ [Dependencies]
├── test/
└── public/
    ├── bower~components [frameworks installed using bower]
    ├── images
    ├── javascript
    └── stylesheets
```
**Heroku Deployment**

This app has been deployed on Heroku. You can test it [here](https://evening-escarpment-9129.herokuapp.com/).
