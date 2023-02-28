(ns todo.handler.todos
  (:require [integrant.core :as ig]))

(defmethod ig/init-key ::index [_ {:keys [todos-index]}]
  (fn [req]
    (let [todos (todos-index)]
      {:status 200
       :body todos})))

(defmethod ig/init-key ::create [_ {:keys [todos-create]}]
  (fn [{:keys [body-params]}]
    (let [todo (todos-create body-params)]
      {:status 200
       :body todo})))