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


