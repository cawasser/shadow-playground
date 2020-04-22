(ns grid
  (:require ["react-grid-layout" :as ReactGridLayout]))




(defn onLayoutChange [on-change prev new]
  ;; note the need to convert the callbacks from js objects

  (let [chg (js->clj new :keywordize-keys true)
        fst (first chg)]
    (if (and
          (not (empty? chg))
          (<= 1 (count chg))
          (not= (:i fst) "null"))
      (do
        (prn "onLayoutChange " on-change)))
        ;  " //// prev " prev
        ;  " //// new " new
        ;  " //// empty? " (empty? chg)
        ;  " //// count " (count chg)
        ;  " //// first id " (:i fst))

        ;(rf/dispatch [:update-layout (js->clj new :keywordize-keys true)])))


    (on-change prev (js->clj new :keywordize-keys true))))


(defn widget-wrapper [w]
  (prn "widget-wrapper " w)

  (let [ret [:div#wrapper {:data-grid (:data-grid w)
                           :key (:key w)
                           :style {:display :flex}}
             w]]

    (print "wrapped " ret)
    ret))


(defn grid
  [{:keys [id content width row-height cols breakpoints item-props on-change empty-text] :as args}]

  (print "setup grid")

  [:div.grid-container
   (into [:> ReactGridLayout/Responsive {:id              id
                                         :class           "layout"
                                         :cols            cols
                                         :width           width
                                         :rowHeight       row-height
                                         :isDraggable     true
                                         :isResizable     true
                                         :draggableHandle ".grid-toolbar"
                                         :draggableCancel ".grid-content"
                                         :breakpoints     breakpoints
                                         :onLayoutChange  (partial onLayoutChange on-change content)}]
     (mapv #(widget-wrapper %) content))])



