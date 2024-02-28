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
