;;; 2.9 Exercises
(ns training.syntax)

(def message "greetings")

(println message)

(let [message "well hello there"]
  (println message))

(println message)

(let [m {:greeting "good morning"
                             :tone "happy"}
      {g :greeting t :tone} m
      {:keys [greeting tone]} m]
  (prn g t)
  (str greeting "-" tone))

;; 3.2 Pre- and post-conditions
(defn f
  "Using pre- and post-conditions.
  Advantages: succinct (also similar to Design by Contract)
  Disadvantages: Assertions can be disabled, less control over error description
  and handling"
  [x]
  {:pre [(pos? x)]
   :post [(neg? %) (int? %)]}
  (- x))

(defn g
  "Check for a condition and throw an exception"
  [x]
  (when-not (pos? x)
    (throw (ex-info "bad input" {:x x})))
  (let [result (- x)]
    (if (and (neg? result) (int? result))
      result
      (throw (ex-info "bad result" {:x x})))))
