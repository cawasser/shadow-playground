(ns macros.slurp
  (:refer-clojure :exclude [slurp]))

(defmacro slurp [file]
  (clojure.core/slurp file))