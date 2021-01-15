(ns four-clojure.prob030)

;; #30 Compress a SequenceSolutions
;; Difficulty:	Easy
;; Topics:	seqs

;; Write a function which removes consecutive duplicates from a sequence.

(def ans0
  (fn compress [coll]
    (if (empty? coll)
      ()
      (let [fst (first coll)
            nxt (next coll)]
        (if (= fst (first nxt))
          (compress nxt)
          (conj (compress nxt) fst))))))

(def ans
  (fn [coll]
    (map first (partition-by identity coll))))

(= (apply str (ans "Leeeeeerrroyyy")) "Leroy")
(= (ans [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (ans [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))
