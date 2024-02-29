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

;; max-fibonacci : Natural -> Natural
(defn max-fibonacci
  "Finds the maximum Fibonacci sequence for number less than the input"
  [max]
  (loop [k 1
         result 1]
    (if (> result max)
      k
      (recur result (+ k result)))))

;; sum-range : integer integer -> integer
(defn sum-range
  "Returns the sum of the numbers in a range between two input integers,
  inclusive of the inputs"
  [m n]
  (reduce + (range m (inc n))))

;; powers-of : Natural Natural -> (Naturals)
(defn powers-of
  "Produces a sequence of powers of m up to a limit of n"
  [m n]
  (take n (iterate #(+ % %) 1)))

;; sans-vowel : String -> [Chars]
(defn sans-vowel
  "Takes a string and produces a sequence of characters with no vowels"
  [s]
  (let [vowels #{\a \e \i \o \u}]
    (remove vowels s)))

;; ratios : [Ratios]
(defn ratios
  "Produces a sequence of (1 1/2 1/3 1/4 ...)"
  []
  (let [inf (map inc (range))]
    (take 5 (map #(/ 1 %) inf))))
