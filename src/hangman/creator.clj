(ns hangman.creator)

(def number-of-tries 5)

(defn question-and-answer [question answer] {:question question :answer answer})

(def questions-and-answers
  [(question-and-answer "Biggest Country On Earth?" "Russia")
   (question-and-answer "Country where Santa Claus lives?" "Finland")
   (question-and-answer "Country where Kangoroo lives?" "Australia")])

(defn create-hidden-letters-row-from [answer]
  (let [number-of-letters-in-anwser (count answer)]
    (take number-of-letters-in-anwser (repeat "_"))))

(defn create-game-metainfo-from [question-and-answer]
  (let [answer (get question-and-answer :answer)]
    {:hidden-letters (create-hidden-letters-row-from answer)
     :number-of-tries-left number-of-tries}))

(defn build-game [question-and-answer]
  (let [game-meta-info (create-game-metainfo-from question-and-answer)]
    (merge question-and-answer game-meta-info)))

(defn pick-random-question-and-answer [] (rand-nth questions-and-answers))

(defn pick-random-game [] (build-game (pick-random-question-and-answer)))
