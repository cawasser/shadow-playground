# Shadow-Playground

A simple template for my shadow-cljs experiments


## Outline

* [Setup Your Build Toolchain](#setup-your-build-toolchain)
* [Configure the Project in Cursive](#configure-the-project-in-cursive)
* [Developing the App](#developing-the-app)
* [Shadow-cljs Differences From Leiningen](#shadow-cljs-differences-from-leiningen)
* [References](#references)


## Setup Your Build Toolchain

This project uses [shadow-cljs](http://shadow-cljs.org/) as the build tooling. shadow-cljs leverages the Node.js
package manager ["npm"](https://www.npmjs.com/) to make integrating Javascript libraries much easier when using Clojurescript.

This means that both npm and shadow-cljs must be installed.

### Installing NPM

For MacOS, use:

    brew install npm

For Windows, follow the instructions at [https://www.npmjs.com/get-npm](https://www.npmjs.com/get-npm).

> This will direct you to install nodejs via [https://nodejs.org/en/](https://nodejs.org/en/). You might just want to go there first
> and then go back to the npmjs page


### Installing shadow-cljs

Once nodejs and npm are installed, run:

    npm install -g shadow-cljs


## Configure the Project in Cursive

Cursive does not current support shadow-cljs project "natively", but there is still a way to use the IDE. If your
project does NOT have a `*.pom` file, run:

    shadow-cljs pom

Once the pom file is built you can open Cursive and select "File | New | Project from Existing Sources...". Navigate to
you project folder and double-click on the `*.pom` file. Once Cursive sorts itself out, click the pull-down at the
top of the Project sidebar window and select "Project Files". This will give you a working view similar to what you
might be used to from a Leiningen project.



## Developing the App

> Note: If this is the very first time you are going to run the app for after cloning it from a repo, you will need to use `npm` to fetch
> all the javascript dependencies. This is actually very easy. Just run:
>
>   npm install
>
> and `npm` will install all the dependencies defined in the package-lock.json file. It is recommended you do this every time you pull from a repo!

At the terminal, navigate into your project folder and run:

    shadow-cljs watch app

This tells shadow-cljs to compile the "app" build defined in `shadow-cljs.edn` and start a hot-reloading watcher, much like [Figwheel](https://figwheel.org/)


## Shadow-cljs Differences From Leiningen

The biggest difference is that shadow-cljs is NOT an all-purpose build tool; it only works with Clojurescript. You can't build Clojure code using shadow-cljs.

Also, shadow-cljs defers to npm for managing your Javascript dependencies. It can handle your Clojurescript ones, but it will be on you as the Developer
to use npm to install any *new* JS packages you use in your app. Then shadow-cljs will remember the packages you have added in `package.json` and `package-lock.json`

## References

### Shadow-cljs and using npm
https://www.freecodecamp.org/news/why-clojurescript-works-so-well-with-npm-128221d302ba/

https://github.com/shadow-cljs/shadow-cljs.github.io

### Grid
https://github.com/strml/react-grid-layout

### ReactHighcharts:
https://github.com/kirjs/react-highcharts

http://kirjs.github.io/react-highcharts/index.html

http://kirjs.github.io/react-highcharts/highmaps.html

http://kirjs.github.io/react-highcharts/more.html

### Highmaps
https://www.highcharts.com/docs/maps/map-collection

http://kirjs.github.io/react-highcharts/highmaps.html

### Accessing extended Highcharts types:
https://github.com/whawker/react-jsx-highcharts/releases/tag/v3.6.0

### CompactPicker (color picker):
http://casesandberg.github.io/react-color/

### TimeLine (Gantt):
https://github.com/guiqui/react-timeline-gantt

https://codesandbox.io/s/3x8nl16p65

### cljs-time:
https://github.com/andrewmcveigh/cljs-time

http://www.andrewmcveigh.com/cljs-time/latest/index.html

