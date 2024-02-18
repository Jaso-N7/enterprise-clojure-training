(ns training.fun-functions-test
  (:require [clojure.test :refer :all]
            [training.fun-functions :refer :all]))

(deftest square-test
  (testing "Computing the square of an input number"
    (is (= 3025 (square 55)))
    (is (zero? (square 0)))
    (is (= 4 (square -2)))))

(deftest squared-test
  (testing "Can compute square of square"
    (are [m n] (= m n)
      1e8     (squared 1e2)
      9150625 (squared 55)
      0       (squared 0)
      256     (squared -4)))
  (testing "Ensures number is less than 100"
    (is (thrown-with-msg? Exception #"Input range too large, expects <= 100"
                          (squared 101)))))

(deftest fib-step-test
  (testing "Returns a vector"
    (vector? (fib-step 0 0)))           ; not sure if this is necessary
  (testing "Returns a vector of computed values"
    (are [m n] (= m n)
      [1 2] (fib-step 1 1)
      [2 3] (fib-step 1 2)
      [3 5] (fib-step 2 3))))
