(ns carousel
  (:require ["pure-react-carousel" :refer [CarouselProvider Slider Slide
                                           Dot DotGroup
                                           ButtonFirst ButtonBack ButtonNext ButtonLast]]))


; Carousel
;  https://github.com/express-labs/pure-react-carousel
;



(defn carousel [contents]

  [:div {:style {:width "650px" :height "450px"}}
   [:> CarouselProvider {:naturalSlideWidth 650
                         :naturalSlideHeight 400
                         :totalSlides (count contents)
                         :dragEnabled false}
    [:> Slider {:class "slider"
                :style {:width "650px" :height "380px"}}
     (for [[idx c] (map-indexed vector contents)]
       [:> Slide {:key idx :index idx} c])]

    [:> ButtonFirst {:class "button is-small"} "First"]
    [:> ButtonBack {:class "button is-small"} "Back"]
    [:> ButtonNext {:class "button is-small"} "Next"]
    [:> ButtonLast {:class "button is-small"} "Last"]

    [:div
     (for [[idx c] (map-indexed vector contents)]
       [:> Dot {:class "button is-small" :slide idx}])]]])


