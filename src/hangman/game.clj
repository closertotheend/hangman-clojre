(ns hangman.game)

(defn answer [game] (get game :answer))

(defn question [game] (get game :question))

(defn hidden-letters [game] (get game :hidden-letters))

(defn number-of-tries [game] (get game :number-of-tries-left))

(defn all-hidden-letters-are-revealed? [game]
  (every? #(not= "_" %) (hidden-letters game)))

(defn are-there-tries-left? [game] (not= 0 (number-of-tries game)))

(defn answer-contains-character? [answer character]
  (.contains answer character))

(defn decrement-number-of-tries [game]
  (merge game [:number-of-tries-left (dec (number-of-tries game))]))

