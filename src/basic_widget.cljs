(ns basic-widget)


(defn rgba [{:keys [r g b a]}]
  (str "rgba(" r "," g "," b "," a ")"))


(defn basic-widget
  ([name custom-content options]
   [:div {:class "vanilla.widgets container"
          :style {:height (get options :viz/height "100%")
                  :width  "100%"}}
    [:div {:class  "title-wrapper grid-toolbar move-cursor"
           :cursor "move"}
     [:div.container.level
      {:style {:background-color (rgba (get options :viz/banner-color {:r 150 :g 150 :b 150 :a 1}))}}

      [:div.level-left.has-text-left
       [:h3 {:class         "title grid-content menu-cursor"
             :cursor        "context-menu"
             :on-mouse-down #(.stopPropagation %)
             :on-click      #()
             :style         {:color (rgba (get options :viz/banner-text-color {:r 0 :g 0 :b 0 :a 1}))}}
        (get options :viz/title)]]

      [:div.level-right.has-text-centered
       [:button.delete.is-large {:style         {:margin-right "10px"}
                                 :on-mouse-down #(.stopPropagation %)
                                 :on-click      #(.stopPropagation %)}]]]]

    [:div {:class         (str (get options :viz/style-name "widget"))
           :style         {:width        "100%"
                           :height       "100%"
                           :marginRight  "10px"
                           :marginLeft   "10px"
                           :marginTop    "5px"
                           :marginBottom "5px"
                           :cursor       :default
                           :align-items  :stretch
                           :display      :flex}
           :on-mouse-down #(.stopPropagation %)}

     custom-content]])

  ([name custom-content]
   (basic-widget name custom-content {})))