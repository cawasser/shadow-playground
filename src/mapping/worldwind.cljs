(ns mapping.worldwind
  ; not sure which of the many version of WorldWind might be the one to use, or if if has any
  ; affect on the Interop issues
  ;
  (:require [reagent.core :as r]
            ["worldwindjs" :as WorldWind :refer (Layer RenderableLayer Position GeographicText TextAttributes addRenderable)]
            ["worldwind-react-globe" :as Globe :refer (addLayer)]))

(defn renderable-layer []
  (let [textLayer      (RenderableLayer. "Mountain")
        point          (Position. 44.1035, -121.7693, 0)
        textAttributes (TextAttributes.)
        text           (GeographicText. point "South Sister")]

    (print "textLayer" (type textLayer))
    (print "point" (type point))
    (print "textAttributes" (type textAttributes))
    (print "text" (type text))

    ; this code "should" work, but fails to compile - what am I missing in the require?
    ;
    ;(.-color textAttributes "#000060")
    ;(.-.depthTest textAttributes false)
    ;
    ;(.-attributes text textAttributes)

    ; this seems to work (well, it doesn't error), but it doesn't return a value
    ; that Globe likes (not a Layer), which is odd as I would thins a "RenderableLayer" is a "Layer"
    (.addRenderable textLayer text)

    (print "textLayer" (type textLayer))
    textLayer))

(defn globe []
  (let [g     (Globe. (clj->js {:layers ["blue-marble-landsat"]}))
        layer (renderable-layer)]

    (print "layer type" (type layer))

    ; this should work, but it doesn't, failing in a variety of ways depending on
    ; what code is used.
    ; the .addLayer doesn't work
    ; (renderable-layer) returns something, but Globe doesn't think it's a valid type (String or Layer)

    ;(.addLayer g layer)

    (print "Globe" g)

    [:> Globe {:layers    ["blue-marble-landsat"
                           ;layer
                           "renderables"]
               :latitude  44.1035 ;28.538336
               :longitude -121.7693 ;-81.379234
               :altitude  35000}]))



