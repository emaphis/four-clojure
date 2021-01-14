(ns four-clojure.prob022)

;; #22 Count a Sequence

;; Difficulty:	Easy
;; Topics:	seqs core-functions


;; Write a function which returns the total number of elements in a sequence.

(def ans0
  (fn [coll]
    (loop [coll coll acc 0]
      (if (empty? coll)
        acc
        (recur (rest coll) (inc acc))))))

(def ans1
  (fn [coll] (reduce (fn [acc elem] (inc acc)) 0 coll)))

(def ans
  #(reduce (fn [acc _] (inc acc)) 0 %))

;;(ans '(1 :b \c "d"))

(= true
   (= (ans '(1 2 3 3 1)) 5)
   (= (ans "Hello World") 11)
   (= (ans [[1 2] [3 4] [5 6]]) 3)
   (= (ans '(13)) 1)
   (= (ans '(:a :b :c)) 3))
