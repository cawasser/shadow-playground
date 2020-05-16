(ns md-viewer
  (:require ["react-markdown" :as ReactMarkdown]))


;;;;;;;;;;;;;;;;;;;;
;
; BULMA.IO BREAKS THIS!
;
; bulma uses specific {:class "tag"} options to do the styles for pretty
; much everything
;
; we will need a way to add these things to the html output.
;
; not sure we can do this with the 'react-markdown' component
;
; I did find https://github.com/arve0/markdown-it-attrs and https://github.com/markdown-it/markdown-it
; which, working together, seem like they could address the problem with bulma, BUT
;
; I don't think markdown-it is a react-component
;



(defn viewer [data]
  ;[:div
     [:> ReactMarkdown {:style {:overflow :auto
                                :height :auto}
                        :source data
                        :escapeHtml false}])


