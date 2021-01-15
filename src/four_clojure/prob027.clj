(ns four-clojure.prob027)

;; #27 Palindrome Detector

;; Difficulty:	Easy
;; Topics:	seqs

;; Write a function which returns true if the given sequence is a palindrome.

;; Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)

;; `seq` converts a string to a sequence of chars
(def ans
  #(= (seq %) (reverse (seq %))))

(= true
   (false? (ans '(1 2 3 4 5)))
   (true? (ans "racecar"))
   (true? (ans [:foo :bar :foo]))
   (true? (ans '(1 1 3 3 1 1)))
   (false? (ans '(:a :b :c))))
