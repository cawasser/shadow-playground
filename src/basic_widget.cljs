(ns basic-widget)


(defn rgba [{:keys [r g b a]}]
  (str "rgba(" r "," g "," b "," a ")"))


(defn title-bar [options]
  [:div.widget-title.title-wrapper.grid-toolbar.move-cursor {:cursor "move"}
   [:div.container.level
    {:style {:background-color (rgba (get options :viz/banner-color {:r 150 :g 150 :b 150 :a 1}))}}

    [:div.level-left.has-text-left
     [:h3.title.grid-content.menu-cursor {:cursor        "context-menu"
                                          :on-mouse-down #(.stopPropagation %)
                                          :on-click      #()
                                          :style         {:color (rgba (get options :viz/banner-text-color {:r 0 :g 0 :b 0 :a 1}))}}
      (get options :viz/title)]]

    [:div.level-right.has-text-centered
     [:button.delete.is-large {:style         {:margin-right "10px"}
                               :on-mouse-down #(.stopPropagation %)
                               :on-click      #(.stopPropagation %)}]]]])

(defn basic-widget
  ([name custom-content options]
   [:div.container.widget-parent {:style {:width "100%" :height "100%"}}
    (title-bar options)

    [:div.widget-content {;:style {:width "100%" :height "100%"} ;:display :flex}
                          :on-mouse-down #(.stopPropagation %)}
     custom-content]])

  ([name custom-content]
   (basic-widget name custom-content {})))


(comment
  {:class         "widget"
   :style         {:width        "100%"
                   :height       "100%"
                   :cursor       :default
                   :align-items  :stretch
                   :display      :flex}}

  ;.widget {
  ;         display: flex;
  ;         flex-flow:column;
  ;                  height: 100%;
  ;         background: white};
  ;
  ;
  ;.widget-banner {
  ;                flex: 0 1 auto;
  ;                background: pink};
  ;
  ;
  ;.widget-content {
  ;                 flex: 1 1 auto;
  ;                 background: green};
  ;

  ())