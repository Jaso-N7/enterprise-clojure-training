(ns training.core-test
  (:require [clojure.test :refer :all]
            [training.core :refer :all]))

(deftest pythag-test
  (testing "can calculate pythageurus"
    (is (= 5.0 (pythag 4 3)))
    (is (= 7.810249675906654 (pythag 5 6))))
  (testing "handles non-numeric arguments"
    (is (thrown-with-msg? Exception #"Bad input, expecting a number"
                          (pythag \a 4)))
    (is (thrown-with-msg? Exception #"Bad input, expecting a number"
                          (pythag 4 \b)))
    (is (thrown-with-msg? Exception #"Bad input, expecting a number"
                          (pythag \a "b")))))

(deftest test-post
  (let [msg "Goodbye world"
        called (atom 0)]
    (with-redefs [str (fn [& args]
                        (swap! called inc)
                        msg)]

      (is (= {:body msg}
             (post "http://service.com/greet")))
      
      (post "http://service.com/greet")
      (post "http://service.com/greet")
      (post "http://service.com/greet")
      (post "http://service.com/greet")
      (post "http://service.com/greet")
      (post "http://service.com/greet")
      
      (is (= 7 @called)))))

(deftest test-score->grade
  (testing "Returns correct grade"
    (let [score1 0 
          score2 51.5 
          score3 100]
      (is (= "A" (score->grade score3)))
      (is (= "C" (score->grade score2)))
      (is (= "F" (score->grade score1))))))

(deftest test-n!
  (testing "Factorial using loop"
    (is (= 120 (n! 5)))
    (is (= 720 (n! 6)))
    (is (= 1 (n! 0))))
  (testing "Factorial using recur"
    (is (= (n! 5) (r! 5)))
    (is (= 720 (r! 6)))
    (is (= (n! 0) (r! 0)))))

(deftest test-max-fibonacci
  (testing "Get max fibonacci number less than specified"
    (is (= 89 (max-fibonacci 100)))))

(deftest test-sum-range
  (is (= 15 (sum-range  1  5)))
  (is (= 40 (sum-range -5 10))))

(deftest test-powers-of
  (is (= '(1 2 4 8 16) (powers-of 2 5)))
  (is (= '(1 2 4 8 16 32 64 128) (powers-of 2 8))))

(deftest test-sans-vowel
  (is (= '(\g \d \l) (sans-vowel "gadol")))
  (is (= '(\N \t \n \l) (sans-vowel "Natanel")))
  (is (= '(\1 \t \w \3) (sans-vowel "1two3"))))

(deftest test-ratios
  (is (= '(1 1/2 1/3 1/4 1/5) (ratios)))
  (is (= '(1 1/2 1/3 1/4 1/5 1/6 1/7 1/8 1/9 1/10) (ratios 10))))

(deftest test-fib-seq
  (is (= '(1 1 2 3 5 8 13 21) (fib-seq 8)))
  (is (= '(1 1 2 3 5 8 13 21 34 55 89 144 233 377) (fib-seq 14))))
