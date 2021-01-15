(ns four-clojure.reduce)

(def lst '(1 2 3 4 5 6 7 8 9 10))
(def len 10)

;; mutation
(def a (atom 0))

(dotimes [i len]
  (swap! a + (nth lst i)))

@a ;; => 55

;; `loop`

(loop [acc 0 i 0]
  (if (= i len)
    acc
    (recur (+ acc (nth lst i)) (inc i))))
;; => 55


(loop [acc 0 lst lst]
  (if (empty? lst)
    acc
    (recur (+ acc (first lst)) (rest lst))))
;; => 55

;; common pattern  - reduce
;; (loop [acc _ lst _]
;;   (if (empty? lst)
;;     acc
;;     (recur (fun acc (first lst)) (rest lst))))

;; (reduce fun acc lst)

(reduce + 0 lst)  ;; => 55
(reduce * 1 lst) ;; => 3628800

;; reductions

;; order doesn't matter
(reduce + 0 '(1 2 3))
;; (+ 0 1) -> 1
;;           (+ 1 2) -> 3
;;                     (+ 3 3) -> 6

;; order matters
(reduce conj '() '(1 2 3))
;; (conj '() 1) -> '(1)
;;                 (conj '(1) 2) -> '(2 1)
;;                                   (conj '(2 1) 3) -> '(3 2 1)

;; (reduce conj '())  => reverse
(reverse '(1 2 3)) ;; => (3 2 1)

(defn my-reverse
  [coll]
  (reduce conj () coll))


;; definition of reduce
(defn my-reduce [fun init coll]
  (loop [acc init lst (seq coll)]
    (if (empty? lst)
      acc
      (recur (fun acc (first lst)) (rest lst)))))

;; any sequence+
- (my-reduce * 1 '(1 2 3)) ;; => 6
(my-reduce * 1 #{1 2 3}) ;; => 6
(my-reduce * 1 [1 2 3])  ;; => 6

;; don't need an initial value - use first value of sequence
(reduce * '(1 2 3)) ;; => 6
(reduce * [1 2 3]) ;; => 6

;; more interesting
(def strlist '("fred" "barney" "fred" "wilma"))

;; accumulate to a map
{"fred" 2 "barney" 1 "wilma" 1}

(defn addtomap [map string]
  (let [oldval
        (if (contains? map string)
          (map string)
          0)]
    (assoc map string (inc oldval))))

(addtomap {} "fred")            ;; => {"fred" 1}
(addtomap {"fred" 1} "barney")         ;; => {"fred" 1, "barney" 1}
(addtomap {"fred" 1, "barney" 1} "fred") ;; => {"fred" 2, "barney" 1}
(addtomap {"fred" 2, "barney" 1} "wilma") ;; => {"fred" 2, "barney" 1, "wilma" 1}

(reduce addtomap {} strlist) ;; => {"fred" 2, "barney" 1, "wilma" 1}

;; better version of addtomap
(defn addtomap [map string]
  (let [oldval (map string 0)]
    (assoc map string (inc oldval))))

(reduce addtomap {} strlist) ;; => {"fred" 2, "barney" 1, "wilma" 1}

;; simplify
(defn addtomap [map string]
  (assoc map string (inc (map string 0))))

(reduce addtomap {} strlist) ;; => {"fred" 2, "barney" 1, "wilma" 1}

;; anonymous
(fn [map string] (assoc map string (inc (map string 0))))

(reduce (fn [map string] (assoc map string (inc (map string 0)))) {} strlist)
;; => {"fred" 2, "barney" 1, "wilma" 1}

;; simplify
(reduce #(assoc %1 %2 (inc (%1 %2 0))) {} strlist)

;; obscure
(reduce (fn[[c s] n] [(+ c n), (str s n)]) [0,""] lst) ;; => [55 "12345678910"]

