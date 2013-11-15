(ns leiningen.new.broken-template
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "broken-template"))

(defn broken-template
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)
              ;; intentionally broken, to allow testing of lein behavior when a template is broken
              :broken-thing (a-function-that-is-not-imported)}]
    (main/info "Generating fresh 'lein new' broken-template project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
