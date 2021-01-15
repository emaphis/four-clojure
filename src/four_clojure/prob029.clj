(ns four-clojure.prob029)

;; #29 Get the Caps

;; Difficulty:	Easy
;; Topics:	strings

;; Write a function which takes a string and returns a new string containing
;; only the capital letters.

(def ans0
  (fn [st]
    (apply str (re-seq #"[A-Z]+" st))))

(def ans
  (fn [st]
    (apply str (map char (filter #(<= (int \A) % (int \Z)) (map int st))))))

(= true
   (= (ans "HeLlO, WoRlD!") "HLOWRD")
   (empty? (ans "nothing"))
   (= (ans "$#A(*&987Zf") "AZ"))
