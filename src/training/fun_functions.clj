(ns training.fun-functions "3.6 Exercises")

;; square : number -> number
(defn square
  "Computes the square of an input number.
  Ex: (square 55) => 3025"
  [num]
  (* num num))

;; squared : number -> Maybe number
(defn squared
  "Takes a number as input and returns the square of square of the input.
  May return an exception.
  Examples:
  (squared 55) => 9,150,625
  (squared -4) => 256
  (squared 101) => Exception"
  [num]
  (when (> num 100)
    (throw (ex-info "Input range too large, expects <= 100" {:num num})))
  ((comp square square) num))

;; fib-step : number number -> [numbers]
(defn fib-step
  "Takes two input numbers and returns a vector where first element is the
  second input and the second element is the sum of the inputs
  Examples:
  (fib-step 1 1) => [1 2]
  (fib-step 1 2) => [2 3]
  (fib-step 2 3) => [3 5]"
  [a b]
  [b (+ a b)])
