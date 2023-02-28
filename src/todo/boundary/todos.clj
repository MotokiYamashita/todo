(ns todo.boundary.todos
  (:require [integrant.core :as ig]
            [next.jdbc.sql :as sql]
            [next.jdbc.date-time]
            [java-time.api :as jt]
            [todo.util :as util]))


(defmethod ig/init-key ::create [_ {:keys [db]}]
  (fn [{:keys [title body]}]
    (-> db
        (sql/insert! :todos
                     {:title title
                      :body body})
        util/structured)))
(defmethod ig/init-key ::index [_ {:keys [db]}]
  (fn []
    (-> db
        (sql/query ["select * from todos"]))))