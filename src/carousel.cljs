(ns carousel
  (:require ["pure-react-carousel" :refer [CarouselProvider Slider Slide
                                           Dot DotGroup
                                           ButtonFirst ButtonBack ButtonNext ButtonLast]]))


; Carousel
;  https://github.com/express-labs/pure-react-carousel
;



(defn carousel [contents]

  [:div {:style {:width "100%" :height "100%"}}
   [:> CarouselProvider {:naturalSlideWidth 640
                         :naturalSlideHeight 410
                         :totalSlides (count contents)
                         :dragEnabled false}
    [:> Slider {:class "slider" :style {:width "100%" :height "100%"}}
     (for [[idx c] (map-indexed vector contents)]
       ^{:key idx} [:> Slide {:key idx :index idx} c])]

    ;[:> ButtonFirst {:class "button is-small"} "First"]
    ;[:> ButtonBack {:class "button is-small"} "Back"]
    ;[:> ButtonNext {:class "button is-small"} "Next"]
    ;[:> ButtonLast {:class "button is-small"} "Last"]

    [:div {:style {:display :flex :justify-content :center :align-items :center}}
     (for [[idx _] (map-indexed vector contents)]
       ^{:key idx} [:> Dot {:class "button is-small" :slide idx}])]]])


