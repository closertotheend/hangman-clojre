(ns hangman.animation)

(defn print-hangman-5-tries-are-left []
  (println "|-----    ")
  (println "|    |    ")
  (println "|        ")
  (println "|       ")
  (println "|     ")
  (println "|         ")
  (println "|")
  (println "|----------"))

(defn print-hangman-4-tries-are-left []
  (println "|-----    ")
  (println "|    |    ")
  (println "|    0    ")
  (println "|       ")
  (println "|     ")
  (println "|         ")
  (println "|")
  (println "|----------"))

(defn print-hangman-3-tries-are-left []
  (println "|-----    ")
  (println "|    |    ")
  (println "|    0    ")
  (println "|    |   ")
  (println "|     ")
  (println "|         ")
  (println "|")
  (println "|----------"))

(defn print-hangman-2-tries-are-left []
  (println "|-----    ")
  (println "|    |    ")
  (println "|    0    ")
  (println "|   -|-   ")
  (println "|     ")
  (println "|         ")
  (println "|")
  (println "|----------"))

(defn print-hangman-1-tries-are-left []
  (println "|-----    ")
  (println "|    |    ")
  (println "|    0    ")
  (println "|   -|-   ")
  (println "|   / ")
  (println "|         ")
  (println "|")
  (println "|----------"))

(defn print-hangman-0-tries-are-left []
  (println "|-----    ")
  (println "|    |    ")
  (println "|    0    ")
  (println "|   -|-   ")
  (println "|   / \\")
  (println "|         ")
  (println "|")
  (println "|-You lost!-"))

(defn print-hangman [number-of-tries]
  (case number-of-tries
    0 (print-hangman-0-tries-are-left)
    1 (print-hangman-1-tries-are-left)
    2 (print-hangman-2-tries-are-left)
    3 (print-hangman-3-tries-are-left)
    4 (print-hangman-4-tries-are-left)
    (print-hangman-5-tries-are-left)))