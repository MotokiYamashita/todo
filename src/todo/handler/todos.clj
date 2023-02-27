(ns todo.handler.todos
  (:require [integrant.core :as ig]))

(defmethod ig/init-key ::index [_ conf]
  (fn [req]
    {:status 200
     :body "ok"}))

(defmethod ig/init-key ::create [_ {:keys [todos-create]}]
  (fn [{:keys [body-params]}]
    (let [todo (todos-create body-params)]
      {:status 200
       :body todo})))