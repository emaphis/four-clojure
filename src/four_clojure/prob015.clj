(ns four-clojure.prob015)

;; #15 Double Down

;; Difficulty:	Elementary
;; Topics:

;; Write a function which doubles a number.

(defn ans [x] (* 2 x))

(= true
   (= (ans 2) 4)

   (= (ans 3) 6)

   (= (ans 11) 22)

   (= (ans 7) 14))
