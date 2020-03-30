(ns carousel
  (:require ["pure-react-carousel" :refer [CarouselProvider Slider Slide
                                           Dot DotGroup
                                           ButtonFirst ButtonBack ButtonNext ButtonLast]]))




(defn carousel [contents]

  [:div.headline {:style {:width "650px" :height "450px"}}
   [:p "Carousel"]
   [:> CarouselProvider {:naturalSlideWidth 650
                         :naturalSlideHeight 400
                         :totalSlides (count contents)}
    [:> Slider {:class "slider"
                :style {:width "650px" :height "380px"}}
     (for [[idx c] (map-indexed vector contents)]
       [:> Slide {:key idx :index idx} c])]

    [:> ButtonFirst {:class "button"} "First"]
    [:> ButtonBack {:class "button"} "Back"]
    [:> ButtonNext {:class "button"} "Next"]
    [:> ButtonLast {:class "button"} "Last"]

    [:div
     (for [[idx c] (map-indexed vector contents)]
       [:> Dot {:class "button" :slide idx}])]]])


