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



