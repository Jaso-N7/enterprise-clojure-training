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

(defn post [url]
  {:body (str "Hello world")})

;; A Score is a Number
;; INTERPRETATION: A test score
;; WHERE: the min is 0 and the max is 100

;; A Grade is one of:
;; - A
;; - B
;; - C
;; - D
;; - F
;; INTERPRETATION: Based on test score, that falls within certain range,
;;                 the grade will be assigned
;; WHERE: the grade is String and
;; A 81% - 100%
;; B 61% - 80%
;; C 41% - 60%
;; D 21% - 40%
;; F 0% - 20% represents fail

;; score->grade : Score -> Grade
(defn score->grade
  "Given a test score, returns a grade"
  [score]
  (cond (<= 81 score 100) "A"
        (<= 61 score 80) "B"
        (<= 41 score 60) "C"
        (<= 21 score 40) "D"
        :else "F"))

;; n! : Natural -> Natural
;; r! : Natural -> Natural
(defn n!
  "Takes a number and calculates the factorial of that number"
  [n]
  (loop [nat n
         accum 1]
    (if (zero? nat)
      accum
      (recur (dec nat) (* accum nat)))))
(defn r!
  "Takes a number and calculates the factorial of that number"
  ([n] (r! n 1))
  ([n res] (if (zero? n) res (recur (dec n) (* res n)))))

