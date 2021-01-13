(ns four-clojure.prob037)

;; #37 Regular Expressions

;; Difficulty:	Elementary
;; Topics:	regex syntax

;; Regex patterns are supported with a special reader macro.

(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))
