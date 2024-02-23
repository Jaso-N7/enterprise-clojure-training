(ns training.core
  (:require [clojure.string :as string])
  (:import [java.util Date]))

(+ 1 2 3)

(println "hello world")

;; Calculate 5!
(reduce * (range 1 6))

;; 2.7 Namespaces
(string/upper-case "shout")

;; 2.8 Regex
(re-seq #"\w+" "the quick brown fox")

;; pythag : number number -> number
(defn pythag
  "Returns the sum of squares for two inputs
  (pythag 4 3) => 5"
  [a b]
  (when-not (and (number? a) (number? b))
    (throw (ex-info "Bad input, expecting a number" {:a a :b b})))
  (Math/sqrt (+ (* a a) (* b b))))



