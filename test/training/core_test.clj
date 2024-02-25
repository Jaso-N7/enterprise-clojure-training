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
