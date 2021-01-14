(ns four-clojure.map)

;;; map examples


(map inc [1 2 3 4 5]) ;; => (2 3 4 5 6)

(map clojure.string/lower-case ["Java" "Imperative" "Weeping"
                                "Clojure" "Learning" "Peace"])
;; => ("java" "imperative" "weeping" "clojure" "learning" "peace")

;; map on two collections
(map * [1 2 3 4] [5 6 7 8]) ;; => (5 12 21 32)

;; items not the same length plus lazy list
(map + [1 2 3] (iterate inc 1)) ;; => (2 4 6)


;; lambda function
(map #(str "Hello " % "!") ["Ford" "Authur" "Tricia"])
;; => ("Hello Ford!" "Hello Authur!" "Hello Tricia!")

;; Pull columns out of a collection of collections.
(apply map vector [[:a :b :c]
                   [:d :e :f]
                   [:g :h :i]])
;; => ([:a :d :g] [:b :e :h] [:c :f :i])

;; map sends key-value pairs from a hash-map
(map #(vector (first %) (* 2 (second %)))
     {:a 1 :b 2 :c 3})
;; => ([:a 2] [:b 4] [:c 6])

;; or the same thing using destructuring
(map (fn [[key value]] [key (* 2 value)])
     {:a 1 :b 2 :c 3})
;; => ([:a 2] [:b 4] [:c 6])

(into {} *1)
;; => {:a 2, :b 4, :c 6}

;; Use a hash-map as a function to translate values in a collection from the 
;; given key to the associated value

(map {2 "two" 3 "three"} [5 3 2])
;; => (nil "three" "two")

;; (filter identity...) removes the the nil
(filter identity (map {2 "two" 3 "three"} [5 3 2]))
;; => ("three" "two")

;; mapping over a map
(map identity  {:key 'val :key1 'val1})
;; => ([:key val] [:key1 val1])

(hash-set (map identity {:key 'val :key1 'val1}))
;; #{([:key val]
;;    [:key1 val1])}

(map second {:key 'val :key1 'val1})
;; => (val val1)

(map last {:x 1 :y 2 :z 3})
;; => (1 2 3)


(map list [1 2 3] '(a b c) '(4 5))
;; => ((1 a 4) (2 b 5))

;; map passed two collection arguments.
(def d1 [:a :b :c])
(#(map list % (range)) d1)
;; => ((:a 0) (:b 1) (:c 2))

;; Used without a collection, map will create a transducer:
(def xf (map inc))
;; We can now apply this transducer to a sequence:
(transduce xf conj (range 5))
;; => [1 2 3 4 5]

;; Extract keyword from a collection of obj
(map :a '({:a 1 :b 0} {:a 2 :b 0} {:a 3 :b 1} {:a 3 :b 0}))
;; => (1 2 3 3)


;; get the keys from a map of certain values
(let [m {:x 1 :y 2 :z 3}
      vset #{2 3}]
  (map first (filter (comp vset last) m)))
;; => (:y :z)

(filter (comp #{2 3} last) {:x 1 :y 2 :z 3})
;; => ([:y 2] [:z 3])

;; destruction
(def ds [{:a 1 :b 2 :c [:foo :bar]}
         {:a 9 :b 8 :c [:baz :zoo]}
         {:a 1 :b 2 :c [:dog :cat]}])

(->> ds 
     (map (fn [{a :a, b :b, [lhs rhs] :c}] 
            [(str "a:" a " c2:" rhs)])))
;; => (["a:1 c2::bar"] ["a:9 c2::zoo"] ["a:1 c2::cat"])


;; taking a collection of functions as an argument
(def sum #(reduce + %))

(def average #(/ (sum %) (count %)))

;; apply a function to a collection
(defn results
  [coll]
  (map #(% coll) [sum average count]))

(results [10 20 30 40 50])
;; => (150 30 5)


;;; 
(def my-coll [{:m 1, :val 12}
              {:m 2, :val 3}
              {:m 3, :val 32}])

(map #(:val %) my-coll)
;; => (12 3 32)

(reduce + (map #(:val %) my-coll))
;; => 47


;; another example - combine lists using map
(def months ["jan" "feb" "mar"])
(def temps [ 5 7 12])

(defn unify
  [month temp]
  {:month month
   :temp temp})

(map unify months temps)
;; => ({:month "jan", :temp 5} {:month "feb", :temp 7} {:month "mar", :temp 12})


;;; mapping two collection
(map vector '(1 2 3 4) [:a :b :c :d])
;; => ([1 :a] [2 :b] [3 :c] [4 :d])


;;; multiplication of rows and columns
(def matrix
  [
   [1  2 3  4   5];=>120
   [1  2 3  4   5];=>120
   [1  2 3  4   5];=>120
   [1  2 3  4   5]]);120  
;; (1 16 81 256 625)

;; Columns multiplication
(apply map * matrix)
;; => (1 16 81 256 625)

;; rows multiplication
(map #(reduce * %) matrix)
;; => (120 120 120 120)
